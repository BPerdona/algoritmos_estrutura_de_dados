public class Livro {

    private String titulo;
    private int nPaginas;
    private String categoria;
    private boolean capaDura;
    private int codigoLivro;

    public Livro(String titulo, int nPaginas, String categoria, boolean capaDura, int codigoLivro) {
        this.titulo = titulo;
        this.nPaginas = nPaginas;
        this.categoria = categoria;
        this.capaDura = capaDura;
        this.codigoLivro = codigoLivro;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getnPaginas() {
        return nPaginas;
    }

    public void setnPaginas(int nPaginas) {
        this.nPaginas = nPaginas;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public boolean isCapaDura() {
        return capaDura;
    }

    public void setCapaDura(boolean capaDura) {
        this.capaDura = capaDura;
    }

    public int getCodigoLivro() {
        return codigoLivro;
    }

    public void setCodigoLivro(int codigoLivro) {
        this.codigoLivro = codigoLivro;
    }
}
