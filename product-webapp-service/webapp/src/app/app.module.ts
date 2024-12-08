import { FormsModule } from '@angular/forms';
import { MbscModule } from '@mobiscroll/angular';
import { CUSTOM_ELEMENTS_SCHEMA, NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { ArenaDetailsComponent } from './arena-details/arena-details.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { MatDatepickerModule } from '@angular/material/datepicker';
import { MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import { MatNativeDateModule } from '@angular/material/core';
import { MbscDatepickerOptions, setOptions } from '@mobiscroll/angular';
import { GroundListComponent } from './ground-list/ground-list.component';
import { HttpClientModule } from '@angular/common/http';

import { LoginComponent } from './login/login.component';
import { SignupComponent } from './signup/signup.component';
import { ReactiveFormsModule } from '@angular/forms';

import { SlotComponent } from './slot/slot.component';

import { ProfileComponent } from './profile/profile.component';
import { GroundOwnerComponent } from './ground-owner/ground-owner.component';
import { OrderhistoryComponent } from './orderhistory/orderhistory.component';
import { OwnerhistoryComponent } from './ownerhistory/ownerhistory.component';
import { LandingPageComponent } from './landing-page/landing-page.component';
import { HeaderComponent } from './header/header.component';
import {MatSelectModule} from '@angular/material/select';




@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    SignupComponent,
    SlotComponent,
    NavbarComponent,
    ArenaDetailsComponent,
    GroundListComponent,

    ProfileComponent,
    GroundOwnerComponent,
    OrderhistoryComponent,
    OwnerhistoryComponent,
    LandingPageComponent,
    HeaderComponent,


  ],

  imports: [
    FormsModule,
    MbscModule,
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    ReactiveFormsModule,
    HttpClientModule,
    MatDatepickerModule,
    MatFormFieldModule,
    MatInputModule,
    MatNativeDateModule,
    BrowserAnimationsModule,
    HttpClientModule,
    MatSelectModule
  ],
  providers: [],
  bootstrap: [AppComponent],
  schemas:[CUSTOM_ELEMENTS_SCHEMA]
})
export class AppModule {}
