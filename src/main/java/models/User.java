package models;

import models.schema.SchemaBuilder;
import models.schema.field.DataType;
import models.schema.field.FieldContrain;
import org.jetbrains.annotations.NotNull;

import java.sql.Statement;
import java.util.Date;

public class User extends Model {

	@Override
	public String getIdentifier() {
		return "" + this.identifier;
	}

	private int identifier;
	private String username;
	private String password_hash;

	private String lastName;
	private String firstName;

	private Date birthDate;
	private String rang;

	public User(String firstName, String lastName, Date birthDate, String password_hash) {
		this.identifier = -1;

		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.password_hash = password_hash;

		this.rang = "user";
	}

	public static class Migration implements models.migration.Migration {

		@Override
		public @NotNull String getSchema() {
			return "User";
		}

		@Override
		public void prepare(SchemaBuilder schema) throws Exception {
			schema.id()
					.field("username", DataType.Integer, FieldContrain.required)
					.field("password_hash", DataType.String, FieldContrain.required)
					.create();
		}

		@Override
		public void revert(SchemaBuilder schema) {

		}
	}
}
