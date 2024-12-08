export interface PaymentDetails {
  paymentId: string;
  amount: number;
  currency: string;
  status: string;
  orderId: string;
  paymentMethod: string;
  customerEmail: string;
  customerName: string;
  paymentCreatedAt: Date;
  transactionTime: Date;
}
