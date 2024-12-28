import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Booking } from './model/booking';
import { HttpClient } from '@angular/common/http';
import { baseUrl } from './constant';

@Injectable({
  providedIn: 'root'
})
export class BookingserviceService {
  private booking_api_url:string=baseUrl+"/booking/getplemail";
  constructor(private httpClient:HttpClient) { }

  getHeaders() {
    const token = localStorage.getItem('authToken');
    return {
      Authorization: `Bearer ${token}`
    };
  }

  getAllBookings(playerEmail:string):Observable<Booking[]>{
    const headers = this.getHeaders();
    return this.httpClient.get<Booking[]>(`${this.booking_api_url}/${playerEmail}`,{headers});
  }

}

