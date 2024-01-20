package Domain;

import javax.persistence.*;

@Entity
@Table(name = "order_info")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name="order_id")
    private int orderId;

    @Column(name="order_no")
    private String orderNo;


    @ManyToOne(cascade ={CascadeType.PERSIST,CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH})
    @JoinColumn(name = "customer_ref")
    private Customer customerRef;

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Customer getCustomerRef() {
        return customerRef;
    }

    public void setCustomerRef(Customer customerRef) {
        this.customerRef = customerRef;
    }
}
