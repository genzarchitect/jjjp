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

  getHeaders() {
    const token = localStorage.getItem('authToken');
    return {
      Authorization: `Bearer ${token}`
    };
  }

  createPayment(amount: number): Observable<any> {
    const headers = this.getHeaders();
    return this.http.post(`${this.baseURL}/payment/${amount}`, null,{headers});
  }

  savePaymentDetails(paymentDetails: PaymentDetails): Observable<any> {
    const headers = this.getHeaders();
    return this.http.post(
      `${this.baseURL}/savepaymentresponse`,
      paymentDetails,{headers}
    );
  }
}
