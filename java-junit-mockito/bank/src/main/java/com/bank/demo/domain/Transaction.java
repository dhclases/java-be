package com.bank.demo.domain;

public class Transaction {
    private String merchant;
    private double mount;

    public Transaction() {
        this("", 0);
    }

    public Transaction(String merchant) {
        this(merchant, 0);
    }

    public Transaction(double mount) {
        this("", mount);
    }

    public Transaction(String merchant, double mount) {
        this.merchant = merchant;
        this.mount = mount;
    }

    private Transaction(Builder builder) {
        this.merchant = builder.merchant;
        this.mount = builder.mount;
    }

    public String getMerchant() {
        return merchant;
    }

    public void setMerchant(String merchant) {
        this.merchant = merchant;
    }

    public double getMount() {
        return mount;
    }

    public void setMount(double mount) {
        this.mount = mount;
    }

    public static class Builder {
        private String merchant;
        private double mount;

        public Builder() {

        }
        public Builder(String merchant, double mount) {
            this.merchant = merchant;
            this.mount = mount;
        }



        public Builder merchant(String merchant) {
            this.merchant = merchant;
            return this;
        }

        public Builder mount(Double mount) {
            this.mount = mount;
            return this;
        }

        public Transaction build() {
            return new Transaction(this);
        }
    }

}
