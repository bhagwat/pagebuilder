package com.pagebuilder

enum DataType {
    PLAIN_TEXT("Plain Text"),
    RICH_TEXT("Rich Text"),
    INTEGER("Number"),
    DECIMAL("Decimal"),
    BOOLEAN("Logical"),
    OPTION("Multiple Choice"),
    CLOUDINARY_ASSET("Asset"),
    PLACEHOLDER("Separator")

    private String title;

    DataType(String title) {
        this.title = title;
    }

    String getTitle() {
        return this.title;
    }
}
