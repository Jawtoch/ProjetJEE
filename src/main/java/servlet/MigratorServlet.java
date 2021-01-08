package servlet;

import bean.UserBean;
import models.*;
import models.migration.Migrations;
import org.jetbrains.annotations.NotNull;
import sql.SQLConnector;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import java.sql.Connection;

public class MigratorServlet implements ServletContextListener {
	@Override
	public void contextInitialized(ServletContextEvent servletContextEvent) {
		final Migrations migrations = new Migrations(System.getenv("DB_USERNAME"), "localhost");
		migrations.add(new UserBean.Migration());
		migrations.add(new Friend.Migration());
		migrations.add(new FriendNotification.Migration());
		migrations.add(new Activity.Migration());
		migrations.add(new Notification.Migration());

		final SQLConnector connector = new SQLConnector();
		final Connection connection = connector.connect();

		try {
			migrations.migrate(connection);
		} catch (Exception e) {
			throw new RuntimeException("Unable to migrate");
		}
	}

	@Override
	public void contextDestroyed(ServletContextEvent servletContextEvent) {

	}
}
