import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Slot } from './model/slot';
import { baseUrl } from './constant';

@Injectable({
  providedIn: 'root'
})
export class SlotformService {

  constructor(private http:HttpClient) { }

  public save(slot:Slot){
    return this.http.post(baseUrl+"/slot/addslot",slot);
  }

  public getGroundByEmail(groundOwnerEmail:string)
  {
    return this.http.get(baseUrl+"/api/v1/ground/"+groundOwnerEmail);
  }

}
