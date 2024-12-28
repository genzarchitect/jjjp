import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../model/user';
import { baseUrl } from '../constant';

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private apiUrl = baseUrl+'/User';
  constructor(private http: HttpClient) { }

  getHeaders() {
    const token = localStorage.getItem('authToken');
    return {
      Authorization: `Bearer ${token}`
    };
  }

  saveDetails(email:String,user: User) :Observable<any[]>{
    const headers = this.getHeaders();
    return this.http.put<any[]>(`${this.apiUrl}/userList/${email}`, user,{headers});
    }

  getUserByEmail(UserEmail: String) : Observable<any[]> {
    const headers = this.getHeaders();
    return this.http.get<any[]>(`${this.apiUrl}/userList/${UserEmail}`,{headers});
  }

  // updateUserDetails(user: User): Observable<any> {
  //     return this.http.put<any>(`${this.apiUrl}/userList/{userEmail}/${user.userEmail}`, user);
  //   }
  // }
}
