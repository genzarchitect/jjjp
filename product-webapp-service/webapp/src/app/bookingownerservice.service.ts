import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Booking } from './model/booking';
import { baseUrl } from './constant';

@Injectable({
  providedIn: 'root'
})
export class BookingownerserviceService {
  private booking_api_url:string=baseUrl+"/booking/getgoemail";
  constructor(private httpClient:HttpClient) { }

  getAllBookings(groundOwnerEmail:string):Observable<Booking[]>{
    
    return this.httpClient.get<Booking[]>(`${this.booking_api_url}/${groundOwnerEmail}`);
  }

}
