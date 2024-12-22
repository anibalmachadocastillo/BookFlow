package pe.edu.cibertec.bookFlow.dto.book;

public record BookDetailDto(Integer bookId,
                            String title,
                            String author,
                            String typeBookGenre,
                            String editorial,
                            String publishedYear,
                            Boolean isAvailable) {
}
