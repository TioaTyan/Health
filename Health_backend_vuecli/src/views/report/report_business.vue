<template>
    <div id="app">
        <div class="content-header">
            <h1>统计分析<small>运营数据</small></h1>
            <el-breadcrumb separator-class="el-icon-arrow-right" class="breadcrumb">
                <el-breadcrumb-item :to="{ path: '/' }">首页</el-breadcrumb-item>
                <el-breadcrumb-item>统计分析</el-breadcrumb-item>
                <el-breadcrumb-item>运营数据</el-breadcrumb-item>
            </el-breadcrumb>
        </div>
        <div class="app-container">
            <div class="box" style="height: 900px">
                <div class="excelTitle">
                    <el-button @click="exportExcel">导出Excel</el-button>运营数据统计
                </div>
                <div class="excelTime">日期：{{reportData.reportDate}}</div>
                <table class="exceTable" cellspacing="0" cellpadding="0">
                    <tr>
                        <td colspan="4" class="headBody">会员数据统计</td>
                    </tr>
                    <tr>
                        <td width='20%' class="tabletrBg">新增会员数</td>
                        <td width='30%'>{{reportData.todayNewMember}}</td>
                        <td width='20%' class="tabletrBg">总会员数</td>
                        <td width='30%'>{{reportData.totalMember}}</td>
                    </tr>
                    <tr>
                        <td class="tabletrBg">本周新增会员数</td>
                        <td>{{reportData.thisWeekNewMember}}</td>
                        <td class="tabletrBg">本月新增会员数</td>
                        <td>{{reportData.thisMonthNewMember}}</td>
                    </tr>
                    <tr>
                        <td colspan="4" class="headBody">预约到诊数据统计</td>
                    </tr>
                    <tr>
                        <td class="tabletrBg">今日预约数</td>
                        <td>{{reportData.todayOrderNumber}}</td>
                        <td class="tabletrBg">今日到诊数</td>
                        <td>{{reportData.todayVisitsNumber}}</td>
                    </tr>
                    <tr>
                        <td class="tabletrBg">本周预约数</td>
                        <td>{{reportData.thisWeekOrderNumber}}</td>
                        <td class="tabletrBg">本周到诊数</td>
                        <td>{{reportData.thisWeekVisitsNumber}}</td>
                    </tr>
                    <tr>
                        <td class="tabletrBg">本月预约数</td>
                        <td>{{reportData.thisMonthOrderNumber}}</td>
                        <td class="tabletrBg">本月到诊数</td>
                        <td>{{reportData.thisMonthVisitsNumber}}</td>
                    </tr>
                    <tr>
                        <td colspan="4" class="headBody">热门套餐</td>
                    </tr>
                    <tr class="tabletrBg textCenter">
                        <td>套餐名称</td>
                        <td>预约数量</td>
                        <td>占比</td>
                        <td>备注</td>
                    </tr>
                    <tr v-for="s in reportData.hotSetmeal" :key='s.id'>
                        <td>{{s.name}}</td>
                        <td>{{s.setmeal_count}}</td>
                        <td>{{s.proportion}}</td>
                        <td></td>
                    </tr>
                </table>
            </div>
        </div>
    </div>
</template>

<script>
    export default {
        data() {
            return {
                reportData: {
                    reportDate: null,
                    todayNewMember: 0,
                    totalMember: 0,
                    thisWeekNewMember: 0,
                    thisMonthNewMember: 0,
                    todayOrderNumber: 0,
                    todayVisitsNumber: 0,
                    thisWeekOrderNumber: 0,
                    thisWeekVisitsNumber: 0,
                    thisMonthOrderNumber: 0,
                    thisMonthVisitsNumber: 0,
                    hotSetmeal: [
                        { name: '阳光爸妈升级肿瘤12项筛查（男女单人）体检套餐', setmeal_count: 200, proportion: 0.222 },
                        { name: '阳光爸妈升级肿瘤12项筛查体检套餐', setmeal_count: 200, proportion: 0.222 }
                    ]
                }  
            }
        },
        created() {
            this.$http.get("http://127.0.0.1:82/report/getBusinessReportData.do").then((res) => {
                this.reportData = res.data.data;
            });
        },
        methods: {
            exportExcel() {
                window.location.href = '/report/exportBusinessReport.do';
            }
        }
    }
</script>

<style>

</style>