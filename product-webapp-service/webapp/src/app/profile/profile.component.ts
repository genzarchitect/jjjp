import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import{UserService} from '../services/user.service';
import { User } from '../model/user';

@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.css']
})
export class ProfileComponent implements OnInit {
  userForm!: FormGroup;
  public  user: User= new User();
  public newUser : any;
  userEmail:String| null = null;
  
  
  isEditing = false;

  constructor(private formBuilder: FormBuilder,private userService: UserService) {}
  


  ngOnInit(): void {
    this.userEmail=localStorage.getItem('email')
    this.userForm = this.formBuilder.group({
      userName: ['', Validators.required],
      userEmail: ['', Validators.email],
      userMobile: ['', Validators.required],
      userGender: ['', Validators.required],
      userAddress: ['', Validators.required]
    });
  
    this.userService.getUserByEmail(this.userEmail!).subscribe((data:any)=>{
      console.log(data);
      
        this.newUser=data;

        console.log("newUser",this.newUser);       
      });
    }
  
  

  editDetails() {
    
    this.isEditing = true;
  }

  
  
  
  saveDetails(data:User) {
    console.log(data);
    console.log(this.newUser.userEmail);
    this.userService.saveDetails(this.newUser.userEmail,data).subscribe((d: any)=>
    console.log("Details saved",d));
    this.isEditing=false;
    
  }


}


