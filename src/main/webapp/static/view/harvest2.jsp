<div style="padding-left: 50px; padding-right: 50px;" ng-controller="Harvest2Controller as showCase">
	<div class="panel panel-default">
		<div class="panel-body">
<!-- 			<table id="example2"  class="table table-striped" cellspacing="0" width="100%"></table> -->
			
			
<!-- 			<p class="text-danger"><strong>{{ showCase.message }}</strong></p> -->
<!--     <br> -->


<!--     <table datatable="" dt-options="showCase.dtOptions" dt-columns="showCase.dtColumns" class="table table-striped"></table> -->

			<div ng-if="showCase.displayTable">
				<table datatable dt-options="showCase.dtOptions"
					dt-columns="showCase.dtColumns" class="table table-striped"></table>
			</div>

		</div>
	</div>
</div>