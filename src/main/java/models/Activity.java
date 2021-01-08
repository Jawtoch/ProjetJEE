package models;

import models.schema.SchemaBuilder;
import models.schema.field.DataType;
import models.schema.field.FieldContrain;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Activity extends Model {

	@Override
	String getIdentifier() {
		return this.id == null ? "none" : String.valueOf(this.id);
	}

	@Nullable private Integer id;
	@NotNull private Integer userId;
	@NotNull private final String date;
	@NotNull private final String heureDebut;
	@NotNull private final String heureFin;
	@NotNull private final String lieu;
	@NotNull private final String adresse;

	public Activity(@Nullable Integer id, @NotNull Integer userId, @NotNull String date, @NotNull String heureDebut, @NotNull String heureFin, @NotNull String lieu, @NotNull String adresse) {
		this.id = id;
		this.userId = userId;
		this.date = date;
		this.heureDebut = heureDebut;
		this.heureFin = heureFin;
		this.lieu = lieu;
		this.adresse = adresse;
	}

	public Activity(@NotNull Integer userId, @NotNull String date, @NotNull String heureDebut, @NotNull String heureFin, @NotNull String lieu, @NotNull String adresse) {
		this(null, userId, date, heureDebut, heureFin, lieu, adresse);
	}

	public static class Migration implements models.migration.Migration {

		@Override
		public @NotNull String getSchema() {
			return "activity";
		}

		@Override
		public void prepare(SchemaBuilder schema) throws Exception {
			schema.id(DataType.Integer)
					.field("userLogin", DataType.String, FieldContrain.required)
					.field("lieu", DataType.String, FieldContrain.required)
					.field("adresse", DataType.String, FieldContrain.required)
					.field("dateActivity", DataType.String, FieldContrain.required)
					.field("heureDebut", DataType.String, FieldContrain.required)
					.field("heureFin", DataType.String, FieldContrain.required)
					.create();
		}

		@Override
		public void revert(SchemaBuilder schema) {

		}
	}
}
