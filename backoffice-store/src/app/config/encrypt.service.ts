import { Injectable } from '@angular/core';
import * as CryptoJS from 'crypto-js';
import { ILoginUser } from '../entities/user/interface/loginUser.interface';

@Injectable({
  providedIn: 'root'
})
export class EncryptService {

  private encryptionKey: string = 'oinwernhweg93jel23nehjt0RXxza';

  constructor() { }

  encryptData(userToSave: any, key: string): string {
    const encryptedData = CryptoJS.AES.encrypt(JSON.stringify(userToSave), key).toString();
    return encryptedData;
  }

  setEncryptionKey(key: string) {
    this.encryptionKey = key;
  }

  getEncryptionKey() {
    return this.encryptionKey;
  }
}
