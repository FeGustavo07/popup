import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  
  valorPai: string | null = "ABC";
  nomePai: string | null = null;

  constructor() { }

  ngOnInit(): void {
  }

  setNome () {
    this.nomePai = "Gustavo";
    this.valorPai = null;
  }
}
