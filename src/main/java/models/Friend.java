package models;

import models.schema.SchemaBuilder;
import models.schema.field.DataType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Friend extends Model {
	@Override
	String getIdentifier() {
		return null;
	}

	@Nullable private Integer id;
	private final String userLogin1;
	private final String userLogin2;

	public Friend(@Nullable Integer id, String userLogin1, String userLogin2) {
		this.id = id;
		this.userLogin1 = userLogin1;
		this.userLogin2 = userLogin2;
	}

	public Friend(String userLogin1, String userLogin2) {
		this(null, userLogin1, userLogin2);
	}

	public static class Migration implements models.migration.Migration {

		@Override
		public @NotNull String getSchema() {
			return "friend";
		}

		@Override
		public void prepare(SchemaBuilder schema) throws Exception {
			schema.id(DataType.Integer)
					.field("userLogin1", DataType.String)
					.field("userLogin2", DataType.String)
					.create();
		}

		@Override
		public void revert(SchemaBuilder schema) {

		}
	}
}
