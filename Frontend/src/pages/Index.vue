<template>
<q-page>
<h2 style="text-align: center">Übersicht</h2>
<div style="margin: 20px">
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