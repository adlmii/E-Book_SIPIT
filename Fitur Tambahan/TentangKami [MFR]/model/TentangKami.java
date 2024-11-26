package TentangKami.model;

public class TentangKami {
    private int id_tentang_kami;
    private String email_developer;
    private String terms_condition;
    private String disclaimer;
    private String privacy_policy;

    // Constructor with all attributes
    public TentangKami(int id_tentang_kami, String email_developer, String terms_condition, String disclaimer, String privacy_policy) {
        this.id_tentang_kami = id_tentang_kami;
        this.email_developer = email_developer;
        this.terms_condition = terms_condition;
        this.disclaimer = disclaimer;
        this.privacy_policy = privacy_policy;
    }

    // Overloaded constructors
    public TentangKami(String terms_condition, String disclaimer) {
        this.terms_condition = terms_condition;
        this.disclaimer = disclaimer;
    }

    public TentangKami(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    // Getters and setters
    public int getId_tentang_kami() {
        return id_tentang_kami;
    }

    public void setId_tentang_kami(int id_tentang_kami) {
        this.id_tentang_kami = id_tentang_kami;
    }

    public String getEmail_developer() {
        return email_developer;
    }

    public void setEmail_developer(String email_developer) {
        this.email_developer = email_developer;
    }

    public String getTerms_condition() {
        return terms_condition;
    }

    public void setTerms_condition(String terms_condition) {
        this.terms_condition = terms_condition;
    }

    public String getDisclaimer() {
        return disclaimer;
    }

    public void setDisclaimer(String disclaimer) {
        this.disclaimer = disclaimer;
    }

    public String getPrivacy_policy() {
        return privacy_policy;
    }

    public void setPrivacy_policy(String privacy_policy) {
        this.privacy_policy = privacy_policy;
    }
}