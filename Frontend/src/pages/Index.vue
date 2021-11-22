<template>
<q-page class="flex flex-center">
<h2>Übersicht</h2>
<div class="q-pa-md">
    <q-table :rows="rows" :columns="columns" row-key="dashboard" />
</div>
</q-page>
</template>

<script>
import { defineComponent } from 'vue'
const columns = [ 
        {
            name: 'username',
            todo: 'todo',
            label: 'Name',
            field: 'dashboard',
        },

        { name: 'todo', label: 'ToDo', field: 'todo'},
        { name: 'task', label: 'Task', field: 'task'},
        { name: 'checkIn', label: 'Start', field: 'checkIn'},
        { name: 'checkOut', label: 'End', field: 'checkOut' },
        { name: 'edit', label: 'Edit', field: 'edit' },
        { name: 'delete', label: 'Delete', field: 'delete' }
    ]
const rows = [
        {
            username: 'Luca',
            todo: 'ToDo',
            task: 'Task',
            checkIn: '17.03.2021',
            checkOut: '19.03.2021',
            edit: 'edit',
            delete: 'delete'
        }
    ]

export default defineComponent({
    data() {
        return {
            checkin: "null",
            columns,
            rows
        }
    },
    mounted() {
    }
}) 
</script>

<style>

</style>
<!-- <template>
<q-page>
    <h2 style="text-align:center; padding-top: 2px">Dashboard</h2>
    <div style="padding-top 10px; padding-left: 10%; padding-right: 10%;">
        <div class="q-pa-md">
            <q-table title="" :rows="rows" :columns="columns" row-key="name" />
        </div>
    </div>
</q-page>
</template>

<script>
import { defineComponent } from 'vue'
const columns = [ 
        {
            name: 'username',
            label: 'Name',
            field: 'name',
            required: true,
            align: 'left',
            sortable: true,
            sort: (a, b, rowA, rowB) => parseInt(a, 10) - parseInt(b, 10),
            sortOrder: 'ad',
            format: (val, row) => `${val}%`,
            style: 'width: 500px',
            classes: 'my-special-class',
            headerStyle: 'width: 500px',
            headerClasses: 'my-special-class'
        },
        { name: 'taskname', label: 'Taskname', field: 'taskname'},
        { name: 'checkIn', label: 'Start date', field: 'checkIn'},
        { name: 'checkOut', label: 'End date', field: 'checkOut' },
        { name: 'edit', label: 'Edit', field: 'edit' },
        { name: 'delete', label: 'Delete', field: 'delete' }
    ]
const rows = [
        {
            username: 'Elia Albanse',
            taskname: 'Task1',
            checkIn: '12.05.2021',
            checkOut: '13.05.2021',
            edit: 'edit button',
            delete: 'delete button'
        }
    ]
export default defineComponent({
    data() {
        return {
            checkin: "null",
            columns,
            rows
        }
    },
    mounted() {
    }
}) 
</script>

<style>
</style> -->