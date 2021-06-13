import java.util.ArrayList;

public class Autor {

    private String nome;
    private int idade;
    private int autorId;
    private ArrayList<Livro> livro = new ArrayList<Livro>();

    public Autor(String nome, int idade, int autorId) {
        this.nome = nome;
        this.idade = idade;
        this.autorId = autorId;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Livro getLivro(int index) {
        return livro.get(index);
    }

    public void addLivro(Livro livro) {
        this.livro.add(livro);
    }

    public void setLivro(Livro livro, int index){
        this.livro.add(index, livro);
    }

    public int getAutorId() {
        return autorId;
    }

    public void setAutorId(int autorId) {
        this.autorId = autorId;
    }

    public void listLivros(){
        System.out.println("\n_____Lista de livros do autor "+nome+"_____\n");
        for(int i=0; i<livro.size(); i++){
            System.out.println("Titulo: "+livro.get(i).getTitulo());
            System.out.println("Codigo: "+livro.get(i).getCodigoLivro());
            System.out.println("Categoria: "+livro.get(i).getCategoria());
            System.out.println("Nº Paginas:"+livro.get(i).getnPaginas());
            int aux;
            if(livro.get(i).isCapaDura()){
                aux=1;
            }else{
                aux=2;
            }
            System.out.println("Tipo da capa (1=Dura/2=Mole): "+aux+"\n\n");

        }
    }

    public int sizeLivros(){
        return livro.size();
    }

}
