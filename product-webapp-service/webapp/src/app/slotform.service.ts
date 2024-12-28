import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Slot } from './model/slot';
import { baseUrl } from './constant';

@Injectable({
  providedIn: 'root'
})
export class SlotformService {

  constructor(private http:HttpClient) { }

  getHeaders() {
    const token = localStorage.getItem('authToken');
    return {
      Authorization: `Bearer ${token}`
    };
  }

  public save(slot:Slot){
    const headers = this.getHeaders();
    return this.http.post(baseUrl+"/slot/addslot",slot,{headers});
  }

  public getGroundByEmail(groundOwnerEmail:string)
  {
    const headers = this.getHeaders();
    return this.http.get(baseUrl+"/api/v1/ground/"+groundOwnerEmail,{headers});
  }

}
