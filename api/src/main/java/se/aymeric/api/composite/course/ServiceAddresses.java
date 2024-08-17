package se.aymeric.api.composite.course;

public class ServiceAddresses {
    private final String cmp;
    private final String crs;
    private final String rev;
    private final String rec;

    public ServiceAddresses() {
        cmp = null;
        crs = null;
        rev = null;
        rec = null;
    }

    public ServiceAddresses(
            String compositeAddress,
            String courseAddress,
            String reviewAddress,
            String recommendationAddress) {

        this.cmp = compositeAddress;
        this.crs = courseAddress;
        this.rev = reviewAddress;
        this.rec = recommendationAddress;
    }

    public String getCmp() {
        return cmp;
    }

    public String getCrs() {
        return crs;
    }

    public String getRev() {
        return rev;
    }

    public String getRec() {
        return rec;
    }
}
