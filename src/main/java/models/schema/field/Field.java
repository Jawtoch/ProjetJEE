package models.schema.field;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Field {

	public String name;

	public DataType dataType;

	public List<FieldContrain> contrains;

	public Field(String name, DataType dataType, FieldContrain... contrains) {
		this.name = name;
		this.dataType = dataType;
		this.contrains = new ArrayList<>(Arrays.asList(contrains));
	}

	public Field(FieldKey fieldKey, DataType dataType, FieldContrain... contrains) {
		this(fieldKey.name(), dataType, contrains);
	}

}
