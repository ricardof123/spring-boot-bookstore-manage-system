package com.fukuda.bookstore.ms.book.enums;

public enum BookCategory {
    UNDEFINED("Undefined"),
    GENERAL("General"),
    FANTASY("Fantasy"),
    ADVENTURE("Adventure"),
    ROMANCE("Romance"),
    CONTEMPORARY("Contemporary"),
    DYSTOPIAN("Dystopian"),
    MYSTERY("Mystery"),
    HORROR("Horror"),
    THRILLER("Thriller"),
    PARANORMAL("Paranormal"),
    HISTORICAL_FICTION("Historical fiction"),
    SCIENCE_FICTION("Science Fiction"),
    MEMOIR("Memoir"),
    COOKING("Cooking"),
    ART("Art"),
    SELF_HELP("Self-help"),
    DEVELOPMENT("Development"),
    MOTIVATIONAL("Motivational"),
    HEALTH("Health"),
    HISTORY("History"),
    TRAVEL("Travel"),
    GUIDE("Guide"),
    FAMILIES_RELATIONSHIPS("Families & Relationships"),
    HUMOR("Humor"),
    CHILDREN("Children’s");

    protected String name;

    BookCategory(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static BookCategory getById(Integer id){
        return id > values().length ? null : values()[id];
    }
}
