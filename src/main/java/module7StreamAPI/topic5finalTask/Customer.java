package module7StreamAPI.topic5finalTask;

import java.util.Arrays;

public class Customer {
    int custKey;
    String mktsegment;
    private char[] varChar;
    private int nationkey;
    private char[] phone;
    private float acctbal;
    private char[] comment;

    public Customer(int custKey, char[] varChar, int nationkey, char[] phone, float acctbal, String mktsegment,
                    char[] comment) {
        this.custKey = custKey;
        this.varChar = varChar;
        this.nationkey = nationkey;
        this.phone = phone;
        this.acctbal = acctbal;
        this.mktsegment = mktsegment;
        this.comment = comment;
    }

    public int getCustKey() {
        return custKey;
    }

    public String getMktsegment() {
        return mktsegment;
    }

    public char[] getVarChar() {
        return varChar;
    }

    public int getNationkey() {
        return nationkey;
    }

    public char[] getPhone() {
        return phone;
    }

    public float getAcctbal() {
        return acctbal;
    }

    public char[] getComment() {
        return comment;
    }

    public void output() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        return "Customer{" +
                "custKey=" + custKey +
                ", varChar=" + Arrays.toString(varChar) +
                ", nationkey=" + nationkey +
                ", phone=" + Arrays.toString(phone) +
                ", acctbal=" + acctbal +
                ", mktsegment=" + mktsegment +
                ", comment=" + Arrays.toString(comment) +
                '}';
    }
}
