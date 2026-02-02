package model.services;

public class PixService implements OnlinePaymentService{

    @Override
    public Double paymentFee(Double amount) {
        return 0.0;
    }

    @Override
    public Double interest(Double amount, Integer months) {
        return amount * 0.01 ;
    }
}
