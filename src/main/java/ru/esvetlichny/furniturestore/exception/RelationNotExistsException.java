package ru.esvetlichny.furniturestore.exception;

// Вызывается, если вложенная (связанная) сущность в БД не найдена
public class RelationNotExistsException extends RuntimeException {
    public RelationNotExistsException(Class<?> type, String attr) {
        super(String.format("Связь %s с атрибутом %s не существует", type.getSimpleName(), attr));
    }
}
