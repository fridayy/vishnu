import {Component, EventEmitter, Input, OnInit, Output} from '@angular/core';

@Component({
  selector: 'app-pager',
  templateUrl: './pager.component.html',
  styleUrls: ['./pager.component.css']
})
export class PagerComponent implements OnInit {

  @Input()
  public totalItems: number;

  @Input()
  public pageSize: number;

  @Output()
  private pageChangedEvent: EventEmitter<number> = new EventEmitter();

  constructor() { }

  ngOnInit() {
  }

  public pageChanged(event: any): void {
    this.pageChangedEvent.emit(event.page);
  }

}
