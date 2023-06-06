import { Component, OnInit } from '@angular/core';
import { User } from '../model/user.model';
import { UserService } from '../service/user.service';
import { FormBuilder, FormGroup, FormControl, Validators  } from '@angular/forms';
import { IUser } from '../interface/user.interface';
import { ConfirmedValidator } from '../validatorPassword';
import { Router } from '@angular/router';

@Component({
  selector: 'app-signup',
  templateUrl: './signup.component.html',
  styleUrls: ['./signup.component.scss']
})
export class SignupComponent implements OnInit {

  userForm!: FormGroup;
  user?: User;
  rol:string = "user";

  constructor( private userService: UserService,
               private fb: FormBuilder,
               private router: Router
             ) { }
  ngOnInit() {
    this.buildForm();
  }

  private buildForm() {
    this.userForm = this.fb.group({
      userName:['', [Validators.required, Validators.minLength(3), Validators.maxLength(15)]],
      name:['', [Validators.required, Validators.minLength(3), Validators.maxLength(50)]],
      surNames:['', [Validators.required, Validators.minLength(3), Validators.maxLength(100)]],
      phone: ['', [Validators.required, Validators.pattern("^[0-9]*$"), Validators.minLength(9), Validators.maxLength(12)]],
      email:['', [Validators.required, Validators.email]],
      password:['', [Validators.required, Validators.minLength(8)]],
      compassword: ['', [Validators.required, Validators.minLength(8)]],
      rol: ['user']
    },
    {
      validator: ConfirmedValidator('password', 'compassword')
    });
  }

  public saveUser(): void {
    const userToSave: IUser = this.createFromForm();
    console.log(userToSave);
    this.insertUser(userToSave);
  }

  private createFromForm(): IUser {
    return {
      ...this.user,
      userName: this.userForm.get(['userName'])!.value,
      name: this.userForm.get(['name'])!.value,
      surNames: this.userForm.get(['surNames'])!.value,
      phone: this.userForm.get(['phone'])!.value,
      email: this.userForm.get(['email'])!.value,
      password: this.userForm.get(['password'])!.value,
      rol:this.rol
    };
  }

  private insertUser(userToSave: IUser) {
    this.userService.insertUser(userToSave).subscribe({
      next: (userInsert) =>{
          alert("Usuario registrado correctamente");
          this.router.navigate(['login']);
      },
      error: (err) => {this.handleError(err);}
    })
  }

  private handleError(err: any): void {
    // ToDo una ventana modal o un alert
  }

}
