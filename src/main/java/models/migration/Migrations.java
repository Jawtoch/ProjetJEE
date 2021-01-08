package models.migration;

import models.schema.SchemaBuilder;
import org.jetbrains.annotations.NotNull;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class Migrations {

	private final List<Migration> migrations;
	@NotNull private final String username;
	@NotNull private final String domain;

	public Migrations(@NotNull String username, @NotNull String domain) {
		this.migrations = new ArrayList<>();
		this.username = username;
		this.domain = domain;
	}

	public void add(Migration migration) {
		this.migrations.add(migration);
	}

	public void migrate(Connection connection) throws Exception {

		for (Migration migration : this.migrations) {
			SchemaBuilder builder = new SchemaBuilder(migration.getSchema(), connection);
			migration.prepare(builder);
		}
	}

	public @NotNull String getSchema() {
		return "base_projet_jee";
	}
}
