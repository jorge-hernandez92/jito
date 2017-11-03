<div style="padding-left: 50px; padding-right: 50px;" ng-controller="Harvest2Controller as showCase">

	<div class="card">
		<div class="card-body" style="text-align: center;">
			<button type="button" class="btn btn-outline-primary">Agregar Venta</button>
			<button type="button" class="btn btn-outline-primary">Agregar Periodo</button>
		</div>
	</div>


	<div class="panel panel-default">
		<div class="panel-body">
			<p class="text-danger"><strong>{{ showCase.message }}</strong></p>
    		<br>
    
			<div ng-if="showCase.displayTable">
					<table datatable="" dt-options="showCase.dtOptions" dt-columns="showCase.dtColumns" dt-instance="showCase.dtInstance" class="table table-striped"></table>
			</div>
			
			<br>

		</div>
	</div>
</div>