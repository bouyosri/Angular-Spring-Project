import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ListFacturesPayerComponent } from './list-factures-payer.component';

describe('ListFacturesPayerComponent', () => {
  let component: ListFacturesPayerComponent;
  let fixture: ComponentFixture<ListFacturesPayerComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ListFacturesPayerComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ListFacturesPayerComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
