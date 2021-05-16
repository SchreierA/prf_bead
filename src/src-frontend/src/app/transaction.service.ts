import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Transaction } from './model/transaction';

@Injectable()
export class TransactionService {

  private transactionUrl: string;

  constructor(private http: HttpClient) {
    this.transactionUrl = 'https://arcane-wildwood-10013.herokuapp.com/transaction';
  }
  
  public registerTransaction(id: number, price: number): void {
    this.http.post<Transaction>(this.transactionUrl, new Transaction(id, price));
  }
}
