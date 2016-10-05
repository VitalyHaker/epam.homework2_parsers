package by.tc.home02.stax;

public enum PearlTagName {
    PEARL, SUBPEARL, DISH, PICTURE, TITLE, SPECIFICATION, WEIGHT, PRICE;

    public static PearlTagName getElementTagName(String element) {
        switch (element) {
            case "pearl":
                return PEARL;
            case "subpearl":
                return SUBPEARL;
            case "dish":
                return DISH;
            case "picture":
                return PICTURE;
            case "title":
                return TITLE;
            case "specification":
                return SPECIFICATION;
            case "weight":
                return WEIGHT;
            case "price":
                return PRICE;
            default:
                throw new EnumConstantNotPresentException(PearlTagName.class, element);
        }
    }
}

