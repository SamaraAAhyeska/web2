@Entity
@Table(name="animes")
public class Anime {
    @Id
    @GeneratedValue ( strategy=GenerationType.IDENTITY)
    private Long id;

    @Column ( name = "name", nullable = false )
    private String name;

    @Column ( name = "description")
    private String description;

     @Column ( genero= "genero")
    private String genero;

    
    @Column ( ano = "ano")
    private String ano;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String  getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }


}