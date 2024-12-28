import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Ground } from '../model/ground';
import { Slot } from '../model/slot';
import { Booking } from '../model/booking';
import th from '@mobiscroll/angular/dist/js/i18n/th';
import { baseUrl } from '../constant';

@Injectable({
  providedIn: 'root',
})
export class GroundService {
  private baseURL = baseUrl+'/api/v1';
  private slotbaseURL = baseUrl+'/slot';
  private bookingURL=baseUrl+'/booking';

  constructor(private http: HttpClient) {}
  getHeaders() {
    const token = localStorage.getItem('authToken');
    return {
      Authorization: `Bearer ${token}`
    };
  }

  getAllGrounds(): Observable<Ground[]> {
    const headers = this.getHeaders();
    return this.http.get<Ground[]>(`${this.baseURL}/allgrounds`,{headers});
  }

  // in ground.service.ts
  getGroundImageUrl(groundId?: string): string {
    if (!groundId) return ''; //  empty string if no groundId is provided.
    return `${this.baseURL}/ground/image/${groundId}`;
  }

  getGroundById(groundId: string): Observable<Ground> {
    const headers = this.getHeaders();
    return this.http.get<Ground>(`${this.baseURL}/groundId/${groundId}`,{headers});
  }

  // Add a new ground
  // addGround(ground: Ground): Observable<any> {
  //   return this.http.post<string>(`${this.baseURL}/addground`, ground);
  // }

  getSlotsByDateForGround(groundId: string, date: string): Observable<Slot[]> {
    const headers = this.getHeaders();
    return this.http.get<Slot[]>(
      `${this.slotbaseURL}/ground/${groundId}/date/${date}`,{headers}
    );
  }

  getAllSlots(): Observable<any> {
    return this.http.get(`${this.slotbaseURL}/slot/slotList`);
  }

  bookSlot(slotId: string): Observable<any> {
    return this.http.post(`${this.slotbaseURL}/slot/book/${slotId}`, {});
  }
  addGround(groundData: any): Observable<any> {
    const headers = this.getHeaders();
    return this.http.post(`${this.baseURL}/addground`, groundData,{headers});
  }

  uploadImage(groundId: string, image: File): Observable<any> {
    const headers = this.getHeaders();
    const formData: FormData = new FormData();
    formData.append('file', image, image.name);
    return this.http.post(`${this.baseURL}/addImage/${groundId}`, formData,{headers});
  }
  saveBooking(bookingDetails:Booking){
    const headers = this.getHeaders();
    return this.http.post(`${this.bookingURL}/addbooking`,bookingDetails,{headers})
  }
}
