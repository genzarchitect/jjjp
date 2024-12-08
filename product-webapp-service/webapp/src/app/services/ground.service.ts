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

  getAllGrounds(): Observable<Ground[]> {
    return this.http.get<Ground[]>(`${this.baseURL}/allgrounds`);
  }

  // in ground.service.ts
  getGroundImageUrl(groundId?: string): string {
    if (!groundId) return ''; //  empty string if no groundId is provided.
    return `${this.baseURL}/ground/image/${groundId}`;
  }

  getGroundById(groundId: string): Observable<Ground> {
    return this.http.get<Ground>(`${this.baseURL}/groundId/${groundId}`);
  }

  // Add a new ground
  // addGround(ground: Ground): Observable<any> {
  //   return this.http.post<string>(`${this.baseURL}/addground`, ground);
  // }

  getSlotsByDateForGround(groundId: string, date: string): Observable<Slot[]> {
    return this.http.get<Slot[]>(
      `${this.slotbaseURL}/ground/${groundId}/date/${date}`
    );
  }

  getAllSlots(): Observable<any> {
    return this.http.get(`${this.slotbaseURL}/slot/slotList`);
  }

  bookSlot(slotId: string): Observable<any> {
    return this.http.post(`${this.slotbaseURL}/slot/book/${slotId}`, {});
  }
  addGround(groundData: any): Observable<any> {
    return this.http.post(`${this.baseURL}/addground`, groundData);
  }

  uploadImage(groundId: string, image: File): Observable<any> {
    const formData: FormData = new FormData();
    formData.append('file', image, image.name);
    return this.http.post(`${this.baseURL}/addImage/${groundId}`, formData);
  }
  saveBooking(bookingDetails:Booking){
    return this.http.post(`${this.bookingURL}/addbooking`,bookingDetails)
  }
}
