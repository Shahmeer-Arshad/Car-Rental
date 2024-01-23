class Customer {
    private String name;
    private String contactInfo;

    public Customer(String name, String contactInfo) {
        this.name = name;
        this.contactInfo = contactInfo;
    }

    public String getName() {
        return this.name;
    }

    public String getContactInfo() {
        return this.contactInfo;
    }

    public void displayCustomerInfo() {
        System.out.println("Name: " + this.name);
        System.out.println("Contact Information: " + this.contactInfo);
    }
}
