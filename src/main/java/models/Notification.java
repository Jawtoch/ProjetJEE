package models;

import models.schema.SchemaBuilder;
import models.schema.field.DataType;
import models.schema.field.FieldContrain;
import org.jetbrains.annotations.NotNull;

public class Notification {

	public static class Migration implements models.migration.Migration {

		@Override
		public @NotNull String getSchema() {
			return "notification";
		}

		@Override
		public void prepare(SchemaBuilder schema) throws Exception {
			schema.id(DataType.Integer)
					.field("userLogin", DataType.String, FieldContrain.required)
					.field("loginUserCovid", DataType.String, FieldContrain.required)
					.field("lieu", DataType.String, FieldContrain.nullable)
					.field("date", DataType.String, FieldContrain.nullable)
					.create();
		}

		@Override
		public void revert(SchemaBuilder schema) {

		}
	}
}
