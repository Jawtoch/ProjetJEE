import bean.UserBean;
import models.Friend;
import models.schema.SchemaBuilder;
import sql.SQLConnector;

import java.sql.Connection;

public class Main {

	public static void main(String[] args) {
		UserBean.Migration migration = new UserBean.Migration();

		SQLConnector connector = new SQLConnector();
		Connection connect = connector.connect();

		SchemaBuilder builder = new SchemaBuilder("User", connect);

		try {
			migration.prepare(builder);

			Friend.Migration friendMigration = new Friend.Migration();
			friendMigration.prepare(new SchemaBuilder("friend", connect));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
