import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Ground } from '../model/ground';
import { Slot } from '../model/slot';
import { SlotformService } from '../slotform.service';

@Component({
  selector: 'app-slot',
  templateUrl: './slot.component.html',
  styleUrls: ['./slot.component.css']
})
export class SlotComponent implements OnInit{

  public email:any;
  public newSlot : Slot;
  public newGround : any[]=[];
  constructor(private slotformService:SlotformService,private router:Router){
    this.newSlot = new Slot();


  }


  ngOnInit(): void {
    this.email=localStorage.getItem('email')
    this.slotformService.getGroundByEmail(this.email).subscribe((data:any)=>{
      console.log(data);
      data.forEach((element:any) => {
        this.newGround.push(element);
        console.log(this.newGround);       
      });
    })


    
  }

  save(data:Slot){
    console.log(data)
    this.slotformService.save(data).subscribe((d:any)=>{
      console.log("Details saved",d);
      this.router.navigate(['/arenas'])
    });

  }

  getGroundByEmail(groundOwnerEmail:string){
    this.slotformService.getGroundByEmail(groundOwnerEmail).subscribe(data=>console.log("Ground names",data));
  }
  

}
