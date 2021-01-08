package bean;

import models.schema.SchemaBuilder;
import models.schema.field.DataType;
import models.schema.field.FieldContrain;
import org.jetbrains.annotations.NotNull;

import java.util.Date;

public class UserBean {

    private int id;
    private String login;
    private String password;
    private String nom;
    private String prenom;
    private Date dateNaissance;
    private String rang;

    public UserBean(){
        this.login = null;
        this.password = null;
        this.nom = null;
        this.prenom = null;
        this.dateNaissance = null;
        this.rang = null;
    }

    public String getLogin(){return this.login;}
    public String getPassword(){return this.password;}
    public String getRang(){return this.rang;}

    public String getNom(){return this.nom;}
    public String getPrenom(){return this.prenom;}
    public Date getDateNaissance(){return this.dateNaissance;}

    public int getId(){return id;}

    public void setLogin(String login){this.login = login;}
    public void setPassword(String password){this.password = password;}
    public void setNom(String nom){this.nom = nom;}
    public void setPrenom(String prenom){this.prenom = prenom;}
    public void setDateNaissance(Date date){this.dateNaissance = date;}
    public void setId(int id){this.id = id;}
    public void setRang(String rang){this.rang = rang;}

    public static class Migration implements models.migration.Migration {
        @Override
        public void prepare(SchemaBuilder schema) throws Exception {
            schema.id(DataType.Integer)
                    .field("login", DataType.String)
                    .field("password", DataType.String)
                    .field("nom", DataType.String)
                    .field("prenom", DataType.String)
                    .field("dateNaissance", DataType.Date)
                    .field("rang", DataType.String)
                    .create();
        }

        @Override
        public void revert(SchemaBuilder schema) {

        }

        @Override
        public @NotNull String getSchema() {
            return "User";
        }
    }

}
