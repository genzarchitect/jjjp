import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { User } from './model/user';
import { baseUrl } from './constant';

@Injectable({
  providedIn: 'root'
})
export class SignupformService {

  constructor(private http:HttpClient) { }

  public save(user:User){
    return this.http.post(baseUrl+"/User/addUser",user);
  }
}
