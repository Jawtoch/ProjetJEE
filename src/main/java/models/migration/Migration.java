package models.migration;

import models.schema.Schema;
import models.schema.SchemaBuilder;


public interface Migration extends Schema {

	void prepare(SchemaBuilder schema) throws Exception;

	void revert(SchemaBuilder schema);

}
