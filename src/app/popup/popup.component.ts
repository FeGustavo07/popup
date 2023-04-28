import { Component, OnInit, Input } from '@angular/core';

import { Iobj } from './object';

@Component({
  selector: 'app-popup',
  templateUrl: './popup.component.html',
  styleUrls: ['./popup.component.css']
})
export class PopupComponent implements OnInit{

  components = ["ABC01", "EFG02", "HIJsdfsdf03", "K04"];

  objComponents: Iobj[] = [];

  parentSelector: boolean = false;

  componentesQueDevemSerAlterados: Iobj[] = [];

  nomeDosComponents: string[] = []

  versaoDosComponents: string[] = []

  versaoDosComponentsNumber: number[] = []

  constructor() { }

  ngOnInit(): void {
    let i = 0;
    this.components.forEach(element => {
      this.objComponents.push({id: i, nome: element, selected: false})
      i++;
    });
  }

  onChange($event: any) {
    const id = $event.target.value;
    const isChecked = $event.target.checked;

    this.objComponents = this.objComponents.map((obj) => {
      if (obj.id == id) {
        obj.selected = isChecked;
        this.parentSelector = false;
        return obj;
      }
      if (id == -1) {
        obj.selected = this.parentSelector;
        return obj;
      }
      return obj;
    });
  }
  
  mostrar() {

    this.componentesQueDevemSerAlterados.length = 0
    this.nomeDosComponents.length = 0
    this.versaoDosComponents.length = 0
    this.versaoDosComponentsNumber.length = 0

    this.objComponents.forEach(element => {
      element.selected == true ? this.componentesQueDevemSerAlterados.push(element) :
      element.selected
    });

    console.log(this.componentesQueDevemSerAlterados)

    this.componentesQueDevemSerAlterados.forEach(element => {
      this.nomeDosComponents.push(element.nome)
    });

    console.log(this.nomeDosComponents)

    this.nomeDosComponents.forEach(element => {
      this.versaoDosComponents.push(element.slice(element.length - 2))
    });

    this.versaoDosComponents.forEach(element => {
      this.versaoDosComponentsNumber.push(parseInt(element))
    });

    console.log(this.versaoDosComponentsNumber)

    console.log(this.versaoDosComponents)
  }
    
}
