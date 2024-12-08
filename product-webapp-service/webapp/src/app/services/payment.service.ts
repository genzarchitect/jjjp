import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { PaymentDetails } from '../model/paymentDetails';
import { baseUrl } from '../constant';

@Injectable({
  providedIn: 'root',
})
export class PaymentService {
  private baseURL = baseUrl+'/api/v2';

  constructor(private http: HttpClient) {}

  createPayment(amount: number): Observable<any> {
    return this.http.post(`${this.baseURL}/payment/${amount}`, null);
  }

  savePaymentDetails(paymentDetails: PaymentDetails): Observable<any> {
    return this.http.post(
      `${this.baseURL}/savepaymentresponse`,
      paymentDetails
    );
  }
}
