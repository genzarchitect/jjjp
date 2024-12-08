import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Login } from './model/login';
import { baseUrl } from './constant';

@Injectable({
  providedIn: 'root'
})
export class LoginformService {
  constructor(private http:HttpClient) { }

  public save(login:Login){
    return this.http.post(baseUrl+"/arena/login",login);
  }

  public getUser(email:String){
    return this.http.get(baseUrl+"/arena/user/"+email);
  }

}
