package models;

import models.schema.SchemaBuilder;
import models.schema.field.DataType;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class FriendNotification extends Model {
	@Override
	String getIdentifier() {
		return this.id == null ? "none" : String.valueOf(this.id);
	}

	@Nullable private final Integer id;
	@NotNull private final String userLogin;
	@NotNull private final String otherUserLogin;
	@NotNull private final String actual;

	public FriendNotification(@Nullable Integer id, @NotNull String userLogin, @NotNull String otherUserLogin,
			@NotNull String actual) {
		this.id = id;
		this.userLogin = userLogin;
		this.otherUserLogin = otherUserLogin;
		this.actual = actual;
	}

	public FriendNotification(@NotNull String userLogin, @NotNull String otherUserLogin,
	                          @NotNull String actual) {
		this(null, userLogin, otherUserLogin, actual);
	}

	public static class Migration implements models.migration.Migration {

		@Override
		public @NotNull String getSchema() {
			return "friendnotification";
		}

		@Override
		public void prepare(SchemaBuilder schema) throws Exception {
			schema.id(DataType.Integer)
					.field("userLogin", DataType.String)
					.field("otherUserLogin", DataType.String)
					.field("actual", DataType.String)
					.create();
		}

		@Override
		public void revert(SchemaBuilder schema) {

		}
	}

}
