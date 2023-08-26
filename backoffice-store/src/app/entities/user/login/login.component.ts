import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators, FormControl  } from '@angular/forms';
import { UserService } from '../service/user.service';
import { ILoginUser } from '../interface/loginUser.interface';
import { User } from '../model/user.model';
import { Router } from '@angular/router';
import { CookieService } from 'ngx-cookie-service';
import { AuthenticationService } from 'src/app/config/authentication.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})

export class LoginComponent implements OnInit{
  userForm!: FormGroup;
  user?: User;
  userLogin?: any;
  userId?: number;
  userToken?: string;

  constructor( private userService: UserService,
               private authentication: AuthenticationService,
               private fb: FormBuilder,
               private router: Router,
               private cookieService: CookieService) { }

  ngOnInit() {
    this.buildForm();
  }

  private buildForm() {
    this.userForm = this.fb.group({
      userName:['', [Validators.required, Validators.minLength(3), Validators.maxLength(15)]],
      password:['', [Validators.required, Validators.minLength(8)]]
    });
  }
  public saveUser(): void {
    const userToSave: ILoginUser = this.createFromForm();
    this.loginUser(userToSave);
  }
  private loginUser(userToSave: ILoginUser) {
    this.userService.logintUser(userToSave).subscribe({
      next: (response) =>{
        this.userLogin = response.userName;
        this.userId = response.id;
        this.userToken = response.token;
        this.cookieService.set('user', this.userLogin, 2 );
        this.cookieService.set('Id', this.userId.toString());
        this.cookieService.set('token', this.userToken);
        this.router.navigate(['']);
        this.authentication.setUsername(this.userLogin);
        alert("Usuario logueado correctamente");
      },
      error: (err) => {this.handleError(err);}
    })
  }

 
  private createFromForm(): ILoginUser {
    return {
      ...this.user,
      userName: this.userForm.get(['userName'])!.value,
      password: this.userForm.get(['password'])!.value,

    };
  }

  private handleError(err: any): void {
    // ToDo una ventana modal o un alert
  }

}

