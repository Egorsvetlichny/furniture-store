package ru.esvetlichny.furniturestore.exception;

// Вызывается, если сущность в БД не найдена
public class EntityNotExistsException extends RuntimeException {
    public EntityNotExistsException(Class<?> type, String attr) {
        super(String.format("Сущность %s с атрибутом %s не существует", type.getSimpleName(), attr));
    }
}
